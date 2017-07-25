set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# libwebrtc_vad.a
ADD_LIBRARY ( webrtc_vad
              STATIC
              gmm.cc
              pitch_based_vad.cc
              pitch_internal.cc
              pole_zero_filter.cc
              standalone_vad.cc
              vad_audio_proc.cc
              vad_circular_buffer.cc
              voice_activity_detector.cc )

target_link_libraries(webrtc_vad webrtc_common_audio_resampler webrtc_codecs_isac log)