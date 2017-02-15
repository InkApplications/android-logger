package inkapplications.android.layoutinjector;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class LayoutInjectorTest {
    @Test
    public void injectContentView() throws Exception {
        Activity mockActivity = Mockito.mock(Activity.class);
        TestLayoutActivity mockLayoutActivity = Mockito.mock(TestLayoutActivity.class);

        LayoutInjector.injectContentView(mockActivity);
        LayoutInjector.injectContentView(mockLayoutActivity);

        Mockito.verify(mockLayoutActivity, Mockito.times(1)).setContentView(42);
        Mockito.verify(mockActivity, Mockito.never()).setContentView(Mockito.anyInt());
    }

    @Test(expected = LayoutNotSpecifiedException.class)
    public void inflateContentViewNotSpecified() throws Exception {
        Fragment mockFragment = Mockito.mock(Fragment.class);
        LayoutInflater mockInflater = Mockito.mock(LayoutInflater.class);
        ViewGroup mockContainer = Mockito.mock(ViewGroup.class);

        LayoutInjector.inflateContentView(mockFragment, mockInflater, mockContainer);
    }

    @Test
    public void inflateContentView() throws Exception {
        Fragment mockFragment = Mockito.mock(TestLayoutFragment.class);
        ViewGroup mockContainer = Mockito.mock(ViewGroup.class);
        View mockView = Mockito.mock(View.class);
        LayoutInflater mockInflater = Mockito.mock(LayoutInflater.class);
        Mockito.when(mockInflater.inflate(42, mockContainer, false)).thenReturn(mockView);

        View view = LayoutInjector.inflateContentView(mockFragment, mockInflater, mockContainer);

        assertSame(mockView, view);
        Mockito.verify(mockInflater, Mockito.times(1)).inflate(42, mockContainer, false);
    }

    @Layout(42)
    class TestLayoutActivity extends Activity {}

    @SuppressLint("ValidFragment")
    @Layout(42)
    class TestLayoutFragment extends Fragment {}
}
