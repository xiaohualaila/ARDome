local application = ae.ARApplication:shared_application()

lua_handler = application:get_lua_handler()
local appLoadedHandlerId = lua_handler:register_handle("onApplicationDidLoad")
local trackingFoundHandlerId = lua_handler:register_handle("onTrackingFound")
local trackingLostHandlerId = lua_handler:register_handle("onTrackingLoss")
application:set_on_loading_finish_handler(appLoadedHandlerId)
application:set_on_tracking_found_handler(trackingFoundHandlerId)
application:set_on_tracking_lost_handler(trackingLostHandlerId)

application:add_scene_from_json("res/simple_scene.json","demo_scene")
application:active_scene_by_name("demo_scene")
application:set_gl_cull_face(true)

local current_scene = application:get_current_scene()

function onApplicationDidLoad()
	local root_node = current_scene:get_root_node()
	io.write("play music..")
	root_node:play_audio("/res/media/bg.mp3", -1, 0)
	root_node:play_pod_animation_all(1, true)
end

function onTrackingFound()
    local root_node = current_scene:get_root_node()
    root_node:set_rotation_by_xyz(0.0, 0.0, 0.0)
end

function onTrackingLoss()
    setBirdEyeView()
    local root_node = current_scene:get_root_node()
    root_node:set_rotation_by_xyz(0.0, 0.0, -35)
end

function setBirdEyeView()
    application:set_camera_look_at("-50.0, -480.0, 380.0","-35, 0, 0", "0.0, 1.0, 0.0")
end
