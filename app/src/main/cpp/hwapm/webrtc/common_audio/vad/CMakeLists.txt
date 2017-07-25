set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

ADD_LIBRARY( webrtc_common_audio_vad
             STATIC
             vad.cc
             vad_core.c
             vad_filterbank.c
             vad_gmm.c
             vad_sp.c
             webrtc_vad.c )

target_link_libraries(webrtc_common_audio_vad log)