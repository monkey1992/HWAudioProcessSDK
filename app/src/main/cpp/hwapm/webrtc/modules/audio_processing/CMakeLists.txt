# 继承上一层的CMakeLists.txt的变量，也可以在这里重新赋值
# C的编译选项是 CMAKE_C_FLAGS
# 指定编译参数，可选
# SET(CMAKE_CXX_FLAGS "-Wno-error=format-security -Wno-error=pointer-sign")

set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -DWEBRTC_NS_FIXED")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -DWEBRTC_NS_FIXED -std=gnu++11 -Wall")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# libwebrtc_apm.a
ADD_LIBRARY( webrtc_apm
             STATIC
             audio_buffer.cc
             audio_processing_impl.cc
             echo_cancellation_impl.cc
             echo_control_mobile_impl.cc
             gain_control_for_experimental_agc.cc
             gain_control_impl.cc
             high_pass_filter_impl.cc
             level_estimator_impl.cc
             noise_suppression_impl.cc
             processing_component.cc
             rms_level.cc
             splitting_filter.cc
             three_band_filter_bank.cc
             typing_detection.cc
             voice_detection_impl.cc )

target_link_libraries(webrtc_apm webrtc_agc webrtc_aec webrtc_aecm webrtc_ns log)
