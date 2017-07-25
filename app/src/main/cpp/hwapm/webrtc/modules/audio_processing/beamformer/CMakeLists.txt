set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX -DWEBRTC_NS_FIXED")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# libwebrtc_beamformer.a
ADD_LIBRARY ( webrtc_beamformer
              STATIC
              array_util.cc
              covariance_matrix_generator.cc
              nonlinear_beamformer.cc )

target_link_libraries(webrtc_beamformer log)
