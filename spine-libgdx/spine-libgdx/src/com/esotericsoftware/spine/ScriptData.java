package com.esotericsoftware.spine;

import com.badlogic.gdx.utils.ObjectMap;

public class ScriptData {
	final String name;
	int order;
	String scriptName;	
	final ObjectMap<String, ScriptProperty> properties = new ObjectMap();
	
	public ScriptData (String name) {
		if (name == null) throw new IllegalArgumentException("name cannot be null.");
		this.name = name;
	}
	
	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public ObjectMap<String, ScriptProperty> getProperties () {
		return properties;
	}
	
	public <T> T getProperty (String name, Class<T> clazz) {
		return (T)properties.get(name);
	}

	public String getName() {
		return name;
	}
	
	public int getOrder () {
		return order;
	}

	public void setOrder (int order) {
		this.order = order;
	}

	public String toString() {
		return name;
	}
	
	public static enum ScriptPropertyType {
		floatType, booleanType, stringType, objectType 
	}
	
	public static abstract class ScriptProperty {
		private final String name;
		private final ScriptPropertyType type;
		
		public ScriptProperty (String name, ScriptPropertyType type) {
			this.name = name;
			this.type = type;
		}
		
		public ScriptPropertyType getType() {
			return type;
		}

		public String getName() {
			return name;
		}
	}
	
	public static class BooleanScriptProperty extends ScriptProperty {
		boolean value;
		
		public BooleanScriptProperty(String name) {
			super(name, ScriptPropertyType.booleanType);
		}
		
		public BooleanScriptProperty (String name, boolean value) {
			this(name);
			this.value = value;
		}

		public boolean getValue() {
			return value;
		}

		public void setValue(boolean value) {
			this.value = value;
		}
	}
	
	public static class FloatScriptProperty extends ScriptProperty {
		float value;
		
		public FloatScriptProperty (String name) {
			super(name, ScriptPropertyType.floatType);
		}
		
		public FloatScriptProperty (String name, float value) {
			this(name);
			this.value = value;
		}

		public float getValue() {
			return value;
		}

		public void setValue(float value) {
			this.value = value;
		}
	}
	
	public static class StringScriptProperty extends ScriptProperty {
		String value;
		
		public StringScriptProperty(String name) {
			super(name, ScriptPropertyType.stringType);
		}
		
		public StringScriptProperty (String name, String value) {
			this(name);
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
