set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# libwebrtc_agc.a
ADD_LIBRARY ( webrtc_agc
              STATIC
              agc.cc
              agc_manager_direct.cc
              histogram.cc
              utility.cc
              legacy/analog_agc.c
              legacy/digital_agc.c )

target_link_libraries(webrtc_agc webrtc_vad log)