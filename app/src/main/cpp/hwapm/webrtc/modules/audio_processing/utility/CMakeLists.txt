set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# libwebrtc_utility.a
ADD_LIBRARY ( webrtc_utility
              STATIC
              delay_estimator.c
              delay_estimator_wrapper.c )

target_link_libraries(webrtc_utility log)
