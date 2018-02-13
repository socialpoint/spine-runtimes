// Fill out your copyright notice in the Description page of Project Settings.

using UnrealBuildTool;

public class SpineUE4 : ModuleRules
{
	public SpineUE4(ReadOnlyTargetRules Target) : base(Target)
	{
		PublicDependencyModuleNames.AddRange(new string[] { "Core", "CoreUObject", "Engine", "InputCore", "SpinePlugin", "RuntimeMeshComponent", "UMG", "Slate", "SlateCore" });
		PublicIncludePaths.AddRange(new string[] { "SpinePlugin/Public", "SpinePlugin/Classes" });

		PrivateDependencyModuleNames.AddRange(new string[] {  });
	}
}
