package com.esotericsoftware.spine;

import com.badlogic.gdx.utils.ObjectMap;
import com.esotericsoftware.spine.ScriptData.BooleanScriptProperty;
import com.esotericsoftware.spine.ScriptData.FloatScriptProperty;
import com.esotericsoftware.spine.ScriptData.ScriptProperty;
import com.esotericsoftware.spine.ScriptData.StringScriptProperty;

public class Script implements Constraint {
	final ScriptData data;
	private final ObjectMap<String, ScriptProperty> properties = new ObjectMap();
	private final Skeleton skeleton;
	ScriptImplementation implementation;
	
	public Script (ScriptData data, Skeleton skeleton) {
		if (data == null) throw new IllegalArgumentException("data cannot be null.");
		if (skeleton == null) throw new IllegalArgumentException("skeleton cannot be null.");
		this.data = data;
		this.skeleton = skeleton;
		copyProperties(data.properties);
	}
	
	public Script (Script script, Skeleton skeleton) {
		if (script == null) throw new IllegalArgumentException("script cannot be null.");
		if (skeleton == null) throw new IllegalArgumentException("skeleton cannot be null.");
		data = script.data;
		this.skeleton = skeleton;
		copyProperties(script.properties);
	}
	
	private void copyProperties (ObjectMap<String, ScriptProperty> properties) {
		this.properties.clear();
		for (ScriptProperty property : properties.values()) {
			if (property instanceof BooleanScriptProperty) {
				BooleanScriptProperty p = (BooleanScriptProperty)property;
				this.properties.put(p.getName(), new BooleanScriptProperty(p.getName(), p.getValue()));
			} else if (property instanceof FloatScriptProperty) {
				FloatScriptProperty p = (FloatScriptProperty)property;
				this.properties.put(p.getName(), new FloatScriptProperty(p.getName(), p.getValue()));
			} else if (property instanceof StringScriptProperty) {
				StringScriptProperty p = (StringScriptProperty)property;
				this.properties.put(p.getName(), new StringScriptProperty(p.getName(), p.getValue()));
			}
		}
	}
	
	public void updatePropertyValues (ScriptProperty[] properties) {
		for (ScriptProperty property : properties) {
			if (property instanceof BooleanScriptProperty) {
				BooleanScriptProperty p = (BooleanScriptProperty)this.properties.get(property.getName());
				if (p != null) p.setValue(((BooleanScriptProperty)property).getValue());
			} else if (property instanceof FloatScriptProperty) {
				FloatScriptProperty p = (FloatScriptProperty)this.properties.get(property.getName());
				if (p != null) p.setValue(((FloatScriptProperty)property).getValue());
			} else if (property instanceof StringScriptProperty) {
				StringScriptProperty p = (StringScriptProperty)this.properties.get(property.getName());
				if (p != null) p.setValue(((StringScriptProperty)property).getValue());
			}
		}
		if (implementation != null) implementation.propertiesChanged(this, skeleton);
	}	
	
	public ObjectMap<String, ScriptProperty> getProperties () {
		return properties;
	}
	
	public <T> T getProperty (String name, Class<T> clazz) {
		return (T)properties.get(name);
	}
	
	@Override
	public int getOrder() {
		return data.order;
	}
	
	public void update() {
		if (implementation != null) implementation.update(this, skeleton);
	}

	public String toString() {
		return data.name;
	}
	
	public interface ScriptImplementation {
		public void update (Script script, Skeleton skeleton);
		public void propertiesChanged (Script script, Skeleton skeleton);
	}	
}
