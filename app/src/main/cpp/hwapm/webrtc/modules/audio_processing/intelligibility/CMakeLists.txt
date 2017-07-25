set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -DWEBRTC_NS_FIXED")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# libwebrtc_intelligibility.a
ADD_LIBRARY ( webrtc_intelligibility
              STATIC
              intelligibility_enhancer.cc
              intelligibility_utils.cc )

target_link_libraries(webrtc_intelligibility log)