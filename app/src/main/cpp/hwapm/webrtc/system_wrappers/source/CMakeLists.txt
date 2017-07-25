set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -DWEBRTC_NS_FIXED")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_ANDROID -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# libwebrtc_system_wrapper.a
ADD_LIBRARY( webrtc_system_wrapper
             STATIC
             aligned_malloc.cc
             file_impl.cc
             logging.cc
             metrics_default.cc
             rw_lock.cc
             rw_lock_posix.cc
             trace_impl.cc
             trace_posix.cc )

target_link_libraries(webrtc_system_wrapper log)
