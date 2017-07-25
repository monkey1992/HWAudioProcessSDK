set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

set ( SRC_LIST
      audio_converter.cc
      audio_ring_buffer.cc
      audio_util.cc
      blocker.cc
      channel_buffer.cc
      fft4g.c
      lapped_transform.cc
      real_fourier.cc
      real_fourier_ooura.cc
      ring_buffer.c
      sparse_fir_filter.cc
      window_generator.cc
      fir_filter.cc )

if (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi")
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi-v7a")
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi-v7a with NEON")
    set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_HAS_NEON")
    set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_HAS_NEON")
    set (CMAKE_ANDROID_ARM_NEON true )
    list ( APPEND
           SRC_LIST
           fir_filter_neon.cc )
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "arm64-v8a")
    set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_HAS_NEON -DWEBRTC_ARCH_ARM64")
    set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_HAS_NEON -DWEBRTC_ARCH_ARM64")
    set (CMAKE_ANDROID_ARM_NEON true )
    list ( APPEND
           SRC_LIST
           fir_filter_neon.cc )
else()
endif()

# webrtc_common_audio.a
ADD_LIBRARY( webrtc_common_audio
             STATIC
             ${SRC_LIST} )

target_link_libraries(webrtc_common_audio log)
