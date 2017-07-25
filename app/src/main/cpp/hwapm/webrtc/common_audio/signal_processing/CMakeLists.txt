set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

set ( SRC_LIST
      auto_corr_to_refl_coef.c
      auto_correlation.c
      complex_fft.c
      copy_set_operations.c
      division_operations.c
      dot_product_with_scale.c
      energy.c
      filter_ar.c
      filter_ma_fast_q12.c
      get_hanning_window.c
      get_scaling_square.c
      ilbc_specific_functions.c
      levinson_durbin.c
      randomization_functions.c
      real_fft.c
      refl_coef_to_lpc.c
      resample.c
      resample_48khz.c
      resample_by_2.c
      resample_by_2_internal.c
      resample_fractional.c
      spl_init.c
      spl_sqrt.c
      splitting_filter.c
      sqrt_of_one_minus_x_squared.c
      vector_scaling_operations.c )

if (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi")
    list ( APPEND
           SRC_LIST
           cross_correlation.c
           downsample_fast.c
           min_max_operations.c
           filter_ar_fast_q12.c
           spl_sqrt_floor_arm.S
           complex_bit_reverse_arm.S
           spl_sqrt_floor.c
           complex_bit_reverse )
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi-v7a")
    list ( APPEND
           SRC_LIST
           cross_correlation.c
           downsample_fast.c
           min_max_operations.c
           filter_ar_fast_q12.c
           spl_sqrt_floor_arm.S
           complex_bit_reverse_arm.S
           spl_sqrt_floor.c
           complex_bit_reverse )
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "armeabi-v7a with NEON")
    set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_HAS_NEON")
    set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_HAS_NEON")
    set (CMAKE_ANDROID_ARM_NEON true )
    list ( APPEND
           SRC_LIST
           cross_correlation_neon.c
           downsample_fast_neon.c
           min_max_operations_neon.c
           filter_ar_fast_q12.c
           spl_sqrt_floor_arm.S
           complex_bit_reverse_arm.S
           spl_sqrt_floor.c
           complex_bit_reverse )
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "arm64-v8a")
    set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_HAS_NEON -DWEBRTC_ARCH_ARM64")
    set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_HAS_NEON -DWEBRTC_ARCH_ARM64")
    set (CMAKE_ANDROID_ARM_NEON true )
    list ( APPEND
           SRC_LIST
           cross_correlation_neon.c
           downsample_fast_neon.c
           min_max_operations_neon.c
           filter_ar_fast_q12.c
           spl_sqrt_floor_arm.S
           complex_bit_reverse_arm.S
           spl_sqrt_floor.c
           complex_bit_reverse )
else()
endif()

# libwebrtc_spl.a
ADD_LIBRARY( webrtc_spl
             STATIC
             ${SRC_LIST} )

target_link_libraries(webrtc_spl log)
