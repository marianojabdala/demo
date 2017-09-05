This is the first attempt to get IntelliJ IDEA working with
SWF from AWS.

## Installation of aspectJ-weaver

* Install aspectJ-weaver plugin on IntelliJ from here: https://plugins.jetbrains.com/plugin/1127-aspectj-weaver
* Enable it, go to Build->Aspect Weaving and check it.
* Go to File->Settings->Build,Execution,Deployment->Compiler->Annotation Processors
* Check Enable annotation processing and then check Module content root
* Rebuild everything.
* On the demo project, go to src->main make the "generate" folder as source root.
