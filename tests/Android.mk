LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := tests

LOCAL_SRC_FILES := $(call all-subdir-java-files)

LOCAL_PACKAGE_NAME := LLuviaFXTests
LOCAL_INSTRUMENTATION_FOR := LLuviaFX

LOCAL_STATIC_JAVA_LIBRARIES := \
        LLuviaFX-android-support-test

LOCAL_JAVA_LIBRARIES := \
        android-support-v4 \

LOCAL_PROGUARD_ENABLED := disabled

LOCAL_JACK_ENABLED := disabled

include $(BUILD_PACKAGE)

include $(CLEAR_VARS)

LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := \
    LLuviaFX-android-support-test:lib/rules-0.3-release.jar

include $(BUILD_MULTI_PREBUILT)
