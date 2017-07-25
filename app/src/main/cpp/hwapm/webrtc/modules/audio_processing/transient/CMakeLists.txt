set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -DWEBRTC_NS_FIXED")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# libwebrtc_transient.a
ADD_LIBRARY ( webrtc_transient
              STATIC
              click_annotate.cc
              file_utils.cc
              moving_moments.cc
              transient_detector.cc
              transient_suppressor.cc
              wpd_node.cc
              wpd_tree.cc )

target_link_libraries(webrtc_transient log)
