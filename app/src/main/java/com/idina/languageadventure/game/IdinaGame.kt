package com.idina.languageadventure.game

import android.content.Context
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.g3d.Environment
import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight
import com.badlogic.gdx.utils.viewport.ScreenViewport

class IdinaGame(private val context: Context) : com.badlogic.gdx.Game() {
    
    lateinit var camera: PerspectiveCamera
    lateinit var modelBatch: ModelBatch
    lateinit var environment: Environment
    private var currentScreen: Screen? = null

    fun onVoiceCommand(command: String) {
        if (currentScreen is VoiceCommandHandler) {
            (currentScreen as VoiceCommandHandler).onVoiceCommand(command)
        }
    }
    
    override fun create() {
        // Set initial screen to NeoTokyo
        setScreen(NeoTokyoScreen(this))
        // Initialize camera
        camera = PerspectiveCamera(67f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        camera.position.set(0f, 5f, 10f)
        camera.lookAt(0f, 0f, 0f)
        camera.near = 1f
        camera.far = 300f
        camera.update()
        
        // Initialize model batch
        modelBatch = ModelBatch()
        
        // Set up lighting
        environment = Environment()
        environment.set(ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f))
        environment.add(DirectionalLight().apply {
            set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f)
        })
        
        // Set the initial screen (e.g., loading screen or main menu)
        // setScreen(LoadingScreen(this))
    }
    
    fun getView() = initializeForView(ScreenViewport())
    
    override fun setScreen(screen: Screen?) {
        currentScreen?.hide()
        currentScreen?.dispose()
        currentScreen = screen
        currentScreen?.show()
        currentScreen?.resize(Gdx.graphics.width, Gdx.graphics.height)
    }
    
    override fun render() {
        // Clear screen
        Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
        
        // Update camera
        camera.update()
        
        // Render current screen
        currentScreen?.render(Gdx.graphics.deltaTime)
    }
    
    override fun dispose() {
        modelBatch.dispose()
        currentScreen?.dispose()
    }
}
