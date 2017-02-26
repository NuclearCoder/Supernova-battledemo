package supernova.battledemo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import supernova.battledemo.BattleDemoGame;
import supernova.battledemo.models.battle.Battle;
import supernova.battledemo.models.character.allies.Ally;
import supernova.battledemo.models.character.enemies.Enemy;
import supernova.battledemo.models.party.Party;
import supernova.battledemo.models.party.PartyMember;
import supernova.battledemo.utils.CircularList;

public class BattleScreen implements Screen {

    private final BattleDemoGame game;

    private final Texture knightTexture;
    private final Texture monsterTexture;

    private final OrthographicCamera camera;

    private Battle battle = null;

    public BattleScreen(final BattleDemoGame game)
    {
        this.game = game;

        knightTexture = new Texture(Gdx.files.internal("Knight.png"));
        monsterTexture = new Texture(Gdx.files.internal("Monster.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        final Party allyParty = new Party(new Ally(1), new Ally(3));
        final Party enemyParty = new Party(new Enemy(2), new Enemy(4));

        battle = new Battle(allyParty, enemyParty);
    }

    public void setBattle(final Battle battle)
    {
        this.battle = battle;
    }

    private void renderUI()
    {
        game.font.draw(game.batch, "Battle screen", 20, 20);

        renderUITurnBar();
    }

    private void renderUITurnBar()
    {
        final CircularList<PartyMember> list = battle.getNextTurns();
        final int length = list.size();

        int x = 20;
        int y = 30;
        int border = 5;

        for (int index = 0; index < length; index++)
        {
            final PartyMember member = list.get(index);
            final Texture texture = member.isAlly() ? knightTexture : monsterTexture;
            game.batch.draw(texture, x, y);

            y += texture.getHeight();
            y += border;
        }
    }

    @Override public void render(final float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin(); // RENDER BEGIN
        renderUI();

        game.batch.end();

        // UPDATE BEGIN

        if (battle != null)
        {
            battle.update(delta);
        }
    }

    @Override public void resize(final int width, final int height)
    {
    }

    @Override public void show()
    {
    }

    @Override public void hide()
    {
    }

    @Override public void pause()
    {
    }

    @Override public void resume()
    {
    }

    @Override public void dispose()
    {
        battle = null;

        knightTexture.dispose();
        monsterTexture.dispose();
    }

}
