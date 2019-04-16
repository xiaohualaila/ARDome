-- bridge.lua --
function HANDLE_SDK_MSG(mapData)
	msg_id = mapData['id']
	if (msg_id == MSG_TYPE_SHAKE) then
        max_acc = mapData['max_acc']
        ARLOG('got max acc '..max_acc)
        if(max_acc < MAX_SHAKE_THRESHOLD) then
            return
        end
        if(AR.current_application.device.shake_enable == false) then
        	return
        end

		if(AR.current_application.device.on_device_shake ~= 0) then
			AR.current_application.device.on_device_shake()
		else
			ARLOG("收到Shake消息，但onDeviceShake方法未定义")
		end
	elseif(msg_id == MSG_TYPE_VOICE_START) then
		if(Speech.callBack ~= nil) then
			Speech.callBack(mapData)
		end
	elseif(msg_id == MSG_TYPE_CAMERA_CHANGE) then
		if(AR.current_application.device.on_camera_change ~= 0) then
			local is_front_camera = mapData['front_camera']
			AR.current_application.device.on_camera_change(is_front_camera)
		end
	elseif(msg_id == MST_TYPE_REMOTE_DEBUG_REC) then
		code = mapData['code']
		loadstring(code)()
	elseif(msg_id == MSG_TYPE_HTML_OPERATION) then
		op = mapData['operation']
		if op == HtmlOperation.loadFinish then
			Html:htmlLoaded(mapData['texture_id'])
		elseif op == HtmlOperation.updateFinish then
			Html:htmlLoaded(mapData['texture_id'])
		end
	elseif(msg_id == MSG_TYPE_TRACK_TIPS) then
		msg_tips_type = mapData['tips_type']
		if (msg_tips_type == TrackTips.trackedDistanceTooFar) then
			if (AR.current_application.on_tracked_distance_too_far ~= nil) then
				AR.current_application.on_tracked_distance_too_far()
			else
				ARLOG("收到track消息，但application on_tracked_too_far方法未定义")
			end
		elseif (msg_tips_type == TrackTips.trackedDistanceTooNear) then 
			if (AR.current_application.on_tracked_distance_too_near ~= nil) then
				AR.current_application.on_tracked_distance_too_near()
			else
				ARLOG("收到track消息，但application on_tracked_too_near方法未定义")
			end
		elseif (msg_tips_type == TrackTips.trackedDistanceNormal) then 
			if (AR.current_application.on_tracked_distance_normal ~= nil) then
				AR.current_application.on_tracked_distance_normal()
			else
				ARLOG("收到track消息，但on_tracked_distance_normal方法未定义")
			end
		else
			ARLOG("收到track消息，但无方法："..msg_tips_type)
		end
	else
		ARLOG("收到未知消息类型: "..msg_id)
	end
end


