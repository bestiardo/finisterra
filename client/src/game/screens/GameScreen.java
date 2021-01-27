package game.screens;

import com.artemis.annotations.Wire;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import game.ClientConfiguration;
import game.systems.ui.UserInterfaceSystem;
import game.utils.Resources;
import net.mostlyoriginal.api.system.core.PassiveSystem;

@Wire
public class GameScreen extends PassiveSystem implements Screen {

    private UserInterfaceSystem userInterfaceSystem;
    private FPSLogger fpsLogger = new FPSLogger();

    public GameScreen() {
        ClientConfiguration config = ClientConfiguration.loadConfig( Resources.CLIENT_CONFIG);
        ClientConfiguration.Init.Video video = config.getInitConfig().getVideo();
        if (!video.isFullScreen()){
            Gdx.graphics.setWindowedMode( video.getWidth(), video.getHeight() );
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClear( GL20.GL_COLOR_BUFFER_BIT );
        world.setDelta(delta);
        world.process();
        fpsLogger.log();
    }

    @Override
    public void resize(int width, int height) {
//        CameraSystem cameraSystem = world.getSystem(CameraSystem.class);
//        cameraSystem.camera.viewportWidth = Tile.TILE_PIXEL_WIDTH * 24f;  //We will see width/32f units!
//        cameraSystem.camera.viewportHeight = cameraSystem.camera.viewportWidth * height / width;
//        cameraSystem.camera.update();
//
//        getWorld().getSystem(UserInterfaceSystem.class).resize(width, height);
//        getWorld().getSystem(BatchRenderingSystem.class).resize(width, height);
        userInterfaceSystem.resize( width, height );
    }

    @Override
    public void show() {
        userInterfaceSystem.show();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
