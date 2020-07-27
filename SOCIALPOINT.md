# Spine Runtimes

This GitHub project is a fork from the [Spine Runtimes](https://github.com/EsotericSoftware/spine-runtimes).

## Structure

The Spine files that we are interested in are in specific subfolders:
* {ESOTERIC_REPO}/spine-cpp/include/spine
* {ESOTERIC_REPO}/spine-cpp/src/spine
* {ESOTERIC_REPO}/spine-cocos2dx/src/spine
* {ESOTERIC_REPO}/spine-cocos2dx/src/spine/v3

and the cocos repo looks like that for now
* {COCOS_REPO}/cocos/editor-support/spine

TODO: use the same structure as esoteric/spine in our cocos2dx folder

## Versions (from esoteric) used to sync the fork

3be202711cffbc82bbf730133a19101bd128822d : 24/07/20 14:25 1st clean version since 2 years :)
ad60096eb1717a08db458d266bcd293b11d7b0ad : 06/06/19 14:13 This was the moment Stefano did a merge directly into cocos/editor-support/spine without updating this repo. He also did a port directly to Esoteric

## github helper

How to work with a fork: instead of researching all the time how to work with a fork because I don't do that daily, here is a recap of last time update

git clone --progress --verbose --recurse-submodules git@github.com:socialpoint/spine-runtimes.git "C:\Prog\sp-spine-runtimes"
git remote -v
git remote add esoteric git@github.com:EsotericSoftware/spine-runtimes.git
git fetch esoteric
git checkout esoteric/3.8
git remote rm esoteric

do what you need to do

git push origin/3.8


