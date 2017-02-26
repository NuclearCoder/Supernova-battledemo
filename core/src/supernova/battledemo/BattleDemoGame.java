package supernova.battledemo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import supernova.battledemo.screens.BattleScreen;
import supernova.battledemo.screens.MainMenuScreen;

import java.util.HashMap;
import java.util.Map;

public class BattleDemoGame extends Game {

    public SpriteBatch batch;
    public BitmapFont font;

    private Map<String, Screen> screens;

    @Override public void create()
    {
        batch = new SpriteBatch();
        font = new BitmapFont();

        screens = new HashMap<>();

        addScreen("MainMenu", new MainMenuScreen(this));
        addScreen("Battle", new BattleScreen(this));

        setScreen("Battle");
    }

    @Override public void render()
    {
        super.render();
    }

    @Override public void dispose()
    {
        batch.dispose();

        screens.values().forEach(Screen::dispose);
    }

    public void addScreen(final String name, final Screen screen)
    {
        screens.putIfAbsent(name, screen);
    }

    public void setScreen(final String name)
    {
        this.setScreen(screens.get(name));
    }

    public Screen getScreen(final String name)
    {
        return screens.get(name);
    }

    public SpriteBatch getBatch()
    {
        return batch;
    }

    public BitmapFont getFont()
    {
        return font;
    }

}
