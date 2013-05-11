package com.liferay.inspire.util.codegen;

import com.liferay.inspire.template.model.ScheduleEntity;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class ModuleGenUtil {

	public void doCompilingModule(String name, ScheduleEntity scheduleEntity){

		String code = getCodeFromScheduleEntity(name, scheduleEntity);
		
		SimpleJavaFileObject fileObject = new DynamicModuleGen(name, code);
		
		JavaFileObject[] fileObjects = new JavaFileObject[]{fileObject};

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		//System.out.println(compiler == null);
		StandardJavaFileManager stdFileManager = compiler.getStandardFileManager(null, Locale.getDefault(), null);

		Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(fileObjects);
		String[] compileOptions = new String[]{"-d", "bin"};
		Iterable<String> compilationOptionss = Arrays.asList(compileOptions);

		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

		CompilationTask compilationTask  = compiler.getTask(null, stdFileManager, diagnostics, compilationOptionss, null, compilationUnits);

		boolean status  = compilationTask.call();

		if(!status){
			for(Diagnostic diagnostic : diagnostics.getDiagnostics()){
				System.out.format("Error in line %d in %s", diagnostic.getLineNumber(), diagnostic);
			}
		}
		try{
			System.out.println("======done and closing File Manger");
			stdFileManager.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	private String getCodeFromScheduleEntity(String name, ScheduleEntity scheduleEntity) {
		
		String source  = "package com.liferay.inspire.util.impl;"+"\n";
		return null;
	}
}
