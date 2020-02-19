package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.imageio.ImageTranscoder;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

// This class is to make the implementation of retry mechanism at suite level
//This needs to called in testng.xml in listener tag
public class RetryAnnotation implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(RetryM.class);
		
	}

}
