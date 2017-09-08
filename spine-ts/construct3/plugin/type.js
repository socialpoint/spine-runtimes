"use strict";

{
	const PLUGIN_CLASS = SDK.Plugins.SpinePlugin;
	
	PLUGIN_CLASS.Type = class SpinePluginType extends SDK.ITypeBase
	{
		constructor(sdkPlugin, iObjectType)
		{
			super(sdkPlugin, iObjectType);
		}
	};
}