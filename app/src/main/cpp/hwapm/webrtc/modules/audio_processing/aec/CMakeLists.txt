set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories(
                     ${CMAKE_CURRENT_SOURCE_DIR}
                     ${HW_APM_SOURCE_DIR} )

set ( SRC_LIST
      aec_resampler.c
      echo_cancellation.c
      aec_core.c
      aec_rdft.c )

if (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi")
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi-v7a")
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi-v7a with NEON")
    set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_HAS_NEON")
    set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_HAS_NEON")
    set (CMAKE_ANDROID_ARM_NEON TRUE)
    list ( APPEND
           SRC_LIST
           aec_core_neon.c
           aec_rdft_neon.c )
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "arm64-v8a")
    set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_HAS_NEON -DWEBRTC_ARCH_ARM64")
    set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_HAS_NEON -DWEBRTC_ARCH_ARM64")
    set (CMAKE_ANDROID_ARM_NEON TRUE)
    list ( APPEND
           SRC_LIST
           aec_core_neon.c
           aec_rdft_neon.c )
else()
endif()

# libwebrtc_aec.a
ADD_LIBRARY ( webrtc_aec
              STATIC
              ${SRC_LIST} )

target_link_libraries(webrtc_aec webrtc_utility log)