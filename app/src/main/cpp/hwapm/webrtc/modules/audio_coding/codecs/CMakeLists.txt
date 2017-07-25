set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -DWEBRTC_NS_FIXED -D__STDC_CONSTANT_MACROS -D__STDC_FORMAT_MACROS -D__UCLIBC__")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# libwebrtc_codecs.a
ADD_LIBRARY ( webrtc_codecs
              STATIC
              audio_decoder.cc
              audio_encoder.cc )

target_link_libraries(webrtc_codecs log)
