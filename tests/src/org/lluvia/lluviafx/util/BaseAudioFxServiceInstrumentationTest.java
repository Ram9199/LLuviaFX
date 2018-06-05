package org.lluvia.lluviafx.util;

import android.content.Context;
import android.content.Intent;
import android.media.lluviafx.AudioEffect;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.lluvia.lluviafx.service.LLuviaFXService;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

/**
 * Created by roman on 3/1/16.
 */
@RunWith(AndroidJUnit4.class)
public abstract class BaseLLuviaFXServiceInstrumentationTest {

    private static final int MAX_ITERATION = 100;

    protected LLuviaFXService.LocalBinder mService;

    @Rule
    public ServiceTestRule mServiceRule = new ServiceTestRule();

    protected void setupService() throws TimeoutException {
        int it = 0;

        /**
         * lol
         * https://code.google.com/p/android/issues/detail?id=180396
         */
        IBinder binder;
        while((binder = mServiceRule.bindService(
                new Intent(InstrumentationRegistry.getTargetContext(),
                        LLuviaFXService.class))) == null && it < MAX_ITERATION){
            it++;
        }
        mService = (LLuviaFXService.LocalBinder) binder;
        assertNotNull(mService);
    }

    protected final Context getContext() {
        return InstrumentationRegistry.getContext();
    }

    protected final Context getTargetContext() {
        return InstrumentationRegistry.getTargetContext();
    }

}
