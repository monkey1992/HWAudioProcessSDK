SET(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX")
SET(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DWEBRTC_POSIX -std=c++11")

# 添加子目录，将会调用子目录中的CMakeLists.txt
ADD_SUBDIRECTORY(base)
ADD_SUBDIRECTORY(modules/audio_processing)
ADD_SUBDIRECTORY(modules/audio_processing/aec)
ADD_SUBDIRECTORY(modules/audio_processing/aecm)
ADD_SUBDIRECTORY(modules/audio_processing/agc)
ADD_SUBDIRECTORY(modules/audio_processing/ns)
ADD_SUBDIRECTORY(modules/audio_processing/utility)
ADD_SUBDIRECTORY(modules/audio_processing/vad)
ADD_SUBDIRECTORY(modules/audio_processing/intelligibility)
ADD_SUBDIRECTORY(modules/audio_processing/transient)
ADD_SUBDIRECTORY(modules/audio_coding/codecs)
ADD_SUBDIRECTORY(modules/audio_coding/codecs/isac/main/source)
ADD_SUBDIRECTORY(modules/audio_processing/beamformer)
ADD_SUBDIRECTORY(common_audio/vad)
ADD_SUBDIRECTORY(common_audio/signal_processing)
ADD_SUBDIRECTORY(common_audio)
ADD_SUBDIRECTORY(common_audio/resampler)
ADD_SUBDIRECTORY(system_wrappers/source)

# 指定include目录
include_directories( ${HW_APM_SOURCE_DIR} )

# 生成so动态库
add_library( hwapmsdk
             SHARED
             ${HW_APM_SOURCE_DIR}/apm_wrapper.cpp)

# 链接各个静态库，注意静态库的顺序会影响到编译过程
target_link_libraries( hwapmsdk
                       webrtc_aec
                       webrtc_aecm
                       webrtc_agc
                       webrtc_ns
                       webrtc_utility
                       webrtc_vad
                       webrtc_apm
                       webrtc_intelligibility
                       webrtc_transient
                       webrtc_beamformer
                       webrtc_common_audio_vad
                       webrtc_spl
                       webrtc_common_audio
                       webrtc_common_audio_resampler
                       webrtc_codecs_isac
                       webrtc_codecs
                       webrtc_system_wrapper
                       webrtc_base
                       android
                       log
                       atomic)