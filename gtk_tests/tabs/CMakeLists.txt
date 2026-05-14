cmake_minimum_required(VERSION 3.10)
project(VME-manager)

find_package(PkgConfig REQUIRED)
pkg_check_modules(GTK4 REQUIRED gtk4)


set(SOURCES
	src/main.cpp
	src/tab1/tab1.cpp
	src/tab2/tab2.cpp
	src/tab3/tab3.cpp
)

add_executable(app ${SOURCES})

target_link_libraries(app ${GTK4_LIBRARIES})
target_include_directories(app PRIVATE ${GTK4_INCLUDE_DIRS})

if(MSVC)
	target_compile_options(app PRIVATE /W4)
else()
	target_compile_options(app PRIVATE -Wall -Wextra -Wpedantic)
endif()
