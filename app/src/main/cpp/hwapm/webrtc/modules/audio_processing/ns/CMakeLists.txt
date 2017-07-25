set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_NS_FIXED")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

set ( SRC_LIST
      noise_suppression.c
      noise_suppression_x.c
      ns_core.c
      nsx_core.c
      nsx_core_c.c )

if (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi")
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi-v7a")
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi-v7a with NEON")
    set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_HAS_NEON")
    set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_HAS_NEON")
    set (CMAKE_ANDROID_ARM_NEON true )
    list ( APPEND
           SRC_LIST
           nsx_core_neon.c )
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "arm64-v8a")
    set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_HAS_NEON -DWEBRTC_ARCH_ARM64")
    set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_HAS_NEON -DWEBRTC_ARCH_ARM64")
    set (CMAKE_ANDROID_ARM_NEON true )
    list ( APPEND
           SRC_LIST
           nsx_core_neon.c )
else()
endif()

# libwebrtc_ns.a
ADD_LIBRARY ( webrtc_ns
              STATIC
              ${SRC_LIST} )

target_link_libraries(webrtc_ns webrtc_spl log)