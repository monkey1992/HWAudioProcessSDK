set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -D__STDC_CONSTANT_MACROS -D__STDC_FORMAT_MACROS -D__UCLIBC__")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -D__STDC_CONSTANT_MACROS -D__STDC_FORMAT_MACROS -D__UCLIBC__ -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# 生成webrtc_base.a
ADD_LIBRARY( webrtc_base
             STATIC
             checks.cc
             criticalsection.cc
             event.cc
             event_tracer.cc
             platform_file.cc
             platform_thread.cc
             timeutils.cc
             logging.cc
             stringencode.cc
             thread_checker_impl.cc )

target_link_libraries(webrtc_base log)
