set (CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DWEBRTC_ANDROID -DWEBRTC_POSIX")
set (CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

# 指定include目录
include_directories(
                     ${CMAKE_CURRENT_SOURCE_DIR}
                     ${HW_APM_SOURCE_DIR}
                     ${HW_APM_SOURCE_DIR}/webrtc/modules/audio_coding/codecs/isac/main/include
                     ${HW_APM_SOURCE_DIR}/webrtc/common_audio/signal_processing/include )

# libwebrtc_codecs_isac.a
ADD_LIBRARY ( webrtc_codecs_isac
              STATIC
              arith_routines.c
              arith_routines_hist.c
              arith_routines_logist.c
              audio_decoder_isac.cc
              audio_encoder_isac.cc
              bandwidth_estimator.c
              crc.c
              decode.c
              decode_bwe.c
              encode.c
              encode_lpc_swb.c
              entropy_coding.c
              fft.c
              filter_functions.c
              filterbank_tables.c
              filterbanks.c
              intialize.c
              isac.c
              lattice.c
              lpc_analysis.c
              lpc_gain_swb_tables.c
              lpc_shape_swb12_tables.c
              lpc_shape_swb16_tables.c
              lpc_tables.c
              pitch_estimator.c
              pitch_filter.c
              pitch_gain_tables.c
              pitch_lag_tables.c
              spectrum_ar_model_tables.c
              transform.c )

target_link_libraries(webrtc_codecs_isac log)
