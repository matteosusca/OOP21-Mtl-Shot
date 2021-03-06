package view.character;

import javafx.scene.image.ImageView;
import model.character.Character;
import model.weapons.Kraber;
import model.weapons.PeaceKeeper;
import util.Vector2D;
import util.direction.DirectionHorizontal;
import util.map.MapConstants;
import util.view.Animation;

/**
 * Implements the View side of a Character.
 */
public class CharacterView {
    private Animation characterIdle;
    private Animation characterIdleUp;
    private Animation characterRun;
    private Animation characterRunUp;
    private Animation characterCrouchIdle;
    private Animation characterCrouchRun;
    private final Animation characterRunDown;
    private final ImageView characterImageView = new ImageView();
    private final Vector2D imageOffset = new Vector2D(0.5, 0.5);

    /**
     * 
     * @param characterIdle
     * @param characterIdleUp
     * @param characterRun
     * @param characterRunUp
     * @param characterCrouchIdle
     * @param characterCrouchRun
     * @param characterRunDown
     */
    public CharacterView(final Animation characterIdle, final Animation characterIdleUp, final Animation characterRun,
            final Animation characterRunUp, final Animation characterCrouchIdle, final Animation characterCrouchRun,
            final Animation characterRunDown) {
        this.characterIdle = characterIdle;
        this.characterIdleUp = characterIdleUp;
        this.characterRun = characterRun;
        this.characterRunUp = characterRunUp;
        this.characterCrouchIdle = characterCrouchIdle;
        this.characterCrouchRun = characterCrouchRun;
        this.characterRunDown = characterRunDown;
    }

    /**
     * Updates the Character's View to reflect any changes on its Model.
     * 
     * @param character
     */
    public void updateCharacter(final Character character) {

        if (character.getWeapon().equals(new Kraber())) {
            this.setWeapon(CharacterSprites.PLAYERIDLESNIPER, CharacterSprites.PLAYERIDLEUPSNIPER,
                    CharacterSprites.PLAYERRUNSNIPER, CharacterSprites.PLAYERRUNUPSNIPER,
                    CharacterSprites.PLAYERCROUCHIDLESNIPER, CharacterSprites.PLAYERCROUCHRUNSNIPER);
        } else if (character.getWeapon().equals(new PeaceKeeper())) {
            this.setWeapon(CharacterSprites.PLAYERIDLESHOTGUN, CharacterSprites.PLAYERIDLEUPSHOTGUN,
                    CharacterSprites.PLAYERRUNSHOTGUN, CharacterSprites.PLAYERRUNUPSHOTGUN,
                    CharacterSprites.PLAYERCROUCHIDLESHOTGUN, CharacterSprites.PLAYERCROUCHRUNSHOTGUN);
        } else {
            this.setWeapon(CharacterSprites.PLAYERIDLERIFLE, CharacterSprites.PLAYERIDLEUPRIFLE,
                    CharacterSprites.PLAYERRUNRIFLE, CharacterSprites.PLAYERRUNUPRIFLE,
                    CharacterSprites.PLAYERCROUCHIDLERIFLE, CharacterSprites.PLAYERCROUCHRUNRIFLE);
        }

        final var adjustY = character.isCrouching() ? character.getHitbox().getY() : 0d;
        characterImageView.setX((character.getPosition().getX() - imageOffset.getX()) * MapConstants.getTilesize());
        characterImageView
                .setY((character.getPosition().getY() - imageOffset.getY() - adjustY) * MapConstants.getTilesize());

        if (character.getSpeed().getX() == 0) {
            switch (character.getAim().getDirection().getY()) {
            case UP:
                switch (character.getAim().getDirection().getX()) {
                case LEFT:
                    characterImageView.setImage(characterIdleUp.get(false));
                    characterIdleUp.animate();
                    break;
                case RIGHT:
                    characterImageView.setImage(characterIdleUp.get(true));
                    characterIdleUp.animate();
                    break;
                default:
                    break;
                }
                break;
            case NEUTRAL:
                switch (character.getAim().getDirection().getX()) {
                case LEFT:
                    characterImageView.setImage(characterIdle.get(false));
                    characterIdle.animate();
                    break;
                case RIGHT:
                    characterImageView.setImage(characterIdle.get(true));
                    characterIdle.animate();
                    break;
                default:
                    break;
                }
                break;
            case DOWN:
                if (character.getSpeed().getY() != 0) {
                    switch (character.getAim().getDirection().getX()) {
                    case LEFT:
                        characterImageView.setImage(characterRunDown.get(false));
                        characterRunDown.animate();
                        break;
                    case RIGHT:
                        characterImageView.setImage(characterRunDown.get(true));
                        characterRunDown.animate();
                        break;
                    default:
                        break;
                    }
                } else {
                    switch (character.getAim().getDirection().getX()) {
                    case LEFT:
                        characterImageView.setImage(characterCrouchIdle.get(false));
                        characterCrouchIdle.animate();
                        break;
                    case RIGHT:
                        characterImageView.setImage(characterCrouchIdle.get(true));
                        characterCrouchIdle.animate();
                        break;
                    default:
                        break;
                    }
                }
                break;
            default:
                break;

            }
            if (character.isCrouching() && character.getAim().getDirection().getX().equals(DirectionHorizontal.LEFT)) {
                characterImageView.setImage(characterCrouchIdle.get(false));
                characterCrouchIdle.animate();
            } else if (character.isCrouching()
                    && character.getAim().getDirection().getX().equals(DirectionHorizontal.RIGHT)) {
                characterImageView.setImage(characterCrouchIdle.get(true));
                characterCrouchIdle.animate();
            }
        } else if (character.getSpeed().getX() != 0) {
            switch (character.getAim().getDirection().getY()) {
            case UP:
                switch (character.getAim().getDirection().getX()) {
                case LEFT:
                    characterImageView.setImage(characterRunUp.get(false));
                    characterRunUp.animate();
                    break;
                case RIGHT:
                    characterImageView.setImage(characterRunUp.get(true));
                    characterRunUp.animate();
                    break;
                default:
                    break;
                }
                break;
            case NEUTRAL:
                switch (character.getAim().getDirection().getX()) {
                case LEFT:
                    characterImageView.setImage(characterRun.get(false));
                    characterRun.animate();
                    break;
                case RIGHT:
                    characterImageView.setImage(characterRun.get(true));
                    characterRun.animate();
                    break;
                default:
                    break;
                }
                break;
            case DOWN:
                if (character.getSpeed().getY() != 0) {
                    switch (character.getAim().getDirection().getX()) {
                    case LEFT:
                        characterImageView.setImage(characterRunDown.get(false));
                        characterRunDown.animate();
                        break;
                    case RIGHT:
                        characterImageView.setImage(characterRunDown.get(true));
                        characterRunDown.animate();
                        break;
                    default:
                        break;
                    }
                } else {
                    switch (character.getAim().getDirection().getX()) {
                    case LEFT:
                        characterImageView.setImage(characterCrouchRun.get(false));
                        characterCrouchRun.animate();
                        break;
                    case RIGHT:
                        characterImageView.setImage(characterCrouchRun.get(true));
                        characterCrouchRun.animate();
                        break;
                    default:
                        break;
                    }
                }
                break;
            default:
                break;
            }
        }
        if (character.isCrouching() && character.getAim().getDirection().getX().equals(DirectionHorizontal.LEFT)) {
            characterImageView.setImage(characterCrouchRun.get(false));
            characterCrouchRun.animate();
        } else if (character.isCrouching()
                && character.getAim().getDirection().getX().equals(DirectionHorizontal.RIGHT)) {
            characterImageView.setImage(characterCrouchRun.get(true));
            characterCrouchRun.animate();
        }
    }

    /**
     * Returns the CharacterView's ImageView.
     * 
     * @return the ImageView.
     */
    public ImageView getCharacterImageView() {
        return characterImageView;
    }

    private void setWeapon(final Animation characterIdle, final Animation characterIdleUp, final Animation characterRun,
            final Animation characterRunUp, final Animation characterCrouchIdle, final Animation characterCrouchRun) {
        this.characterIdle = characterIdle;
        this.characterIdleUp = characterIdleUp;
        this.characterRun = characterRun;
        this.characterRunUp = characterRunUp;
        this.characterCrouchIdle = characterCrouchIdle;
        this.characterCrouchRun = characterCrouchRun;
    }

}
