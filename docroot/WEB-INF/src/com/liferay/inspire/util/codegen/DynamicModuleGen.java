package com.liferay.inspire.util.codegen;

import java.io.IOException;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;
import javax.tools.JavaFileObject.Kind;

public class DynamicModuleGen extends SimpleJavaFileObject{
	private String qualifiedName;
	private String sourceCode;
//	private String source = "package com.inspire.javaapi;\n"+
//            "public class HelloWorld {"+"\n"+
//           	" public static void main(String[] args){"+"\n"+
//           "  System.out.println(\"Hello World ==== Testing Creating Class Dynamically\");"+"\n"+
//           	" }"+"\n"+
//           "}";
	
	protected DynamicModuleGen(String name, String code) {
		
		super(URI.create("string:///"+name.replaceAll("\\.", "/")), Kind.SOURCE);
		// TODO Auto-generated constructor stub
//		System.out.println(code);
//		System.out.println(name);
		this.qualifiedName = name;
		this.sourceCode = code;
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
			throws IOException {
		
		return sourceCode;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
}
