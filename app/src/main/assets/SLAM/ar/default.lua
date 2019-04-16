local app_controller = ae.ARApplicationController:shared_instance()
local application = app_controller:add_application_with_type(4, "slam_bear_application")

--注册app加载完成之后的回调
lua_handler = application:get_lua_handler()
local appLoadedHandlerId = lua_handler:register_handle("onApplicationDidLoad")
application:set_on_loading_finish_handler(appLoadedHandlerId)

--从JSON中加载场景
application:add_scene_from_json("res/simple_scene.json","demo_scene")
--激活场景
application:active_scene_by_name("demo_scene")

local current_scene = application:get_current_scene()

local is_dismiss_guide = false;

function onApplicationDidLoad()
    local current_scene = application:get_current_scene()
    local pod_node = current_scene:get_node_by_name("root_entity")
    pod_node:play_pod_animation_all(1.0,true)
    local reset_node = current_scene:get_node_by_name("reset")
    local guide_node = current_scene:get_node_by_name("arrow_guide")

    local is_first_show_arrow = true
    local offscreen_show_handler_id = lua_handler:register_handle("on_offscreen_show")
    local offscreen_hide_handler_id = lua_handler:register_handle("on_offscreen_hide")
    local reset_click_handler_id = lua_handler:register_handle("on_reset_click")
    reset_node:set_event_handler(0, reset_click_handler_id)

    ae.LuaUtils:call_function_after_delay(500, "register_offscreen_handlers")

    function register_offscreen_handlers()
    	application:set_show_offscreen_button_handler(offscreen_show_handler_id)
    	application:set_hide_offscreen_button_handler(offscreen_hide_handler_id)
    end

    function on_offscreen_show()
    	io.write("offscreen_button_show")
    	if (is_first_show_arrow) then
    		io.write("arrow_guide_show")
    		is_first_show_arrow = false
    		guide_node:set_visible(true)
            ae.LuaUtils:call_function_after_delay(3000, "dismis_guide")
    	else
    		reset_node:set_visible(true)
    	end

    end

    function on_offscreen_hide()
    	io.write("offscreen_button_hide")
    	guide_node:set_visible(false)
    	reset_node:set_visible(false)
        if (not is_dismiss_guide) then 
            is_dismiss_guide = true
        end
    end

    function on_reset_click()
    	io.write("reset_click")
    	local mapData = ae.MapData:new() 
		mapData:put_int("id", 4100) 
		mapData:put_float("x",0.3)
		mapData:put_float("y",0.6)
		mapData:put_int("type",2)
		mapData:put_float("distance",1000)
		lua_handler:send_message_tosdk(mapData)
    end

    function dismis_guide( ) 
        if (not is_dismiss_guide) then 
            guide_node:set_visible(false)
            reset_node:set_visible(true)
        end
    end
end
