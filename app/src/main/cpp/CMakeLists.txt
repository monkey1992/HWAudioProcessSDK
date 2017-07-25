#指定需要CMAKE的最小版本
cmake_minimum_required(VERSION 3.4.1)

# 设置编译类型-Debug or Release
SET(CMAKE_BUILD_TYPE "Debug")

# 设置编译参数
if( CMAKE_BUILD_TYPE STREQUAL "Debug" )
    SET(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -g -Wall -Wno-unused-variable -pthread")
elseif( CMAKE_BUILD_TYPE STREQUAL "Release" )
    SET(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -O2 -pthread -fopenmp")
endif()
message("Build Type:"${CMAKE_BUILD_TYPE} ${CMAKE_CXX_FLAGS})

SET(CMAKE_CXX_FLAGS_DEBUG "$ENV{CXXFLAGS} -O0 -Wall -g -ggdb ")
SET(CMAKE_CXX_FLAGS_RELEASE "$ENV{CXXFLAGS} -O3 -Wall")

# 设置生成的.so动态库的输出路径
SET(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../jniLibs/${ANDROID_ABI})

# 添加子目录,将会调用子目录中的CMakeLists.txt
ADD_SUBDIRECTORY(hwapm)
