This is the first attempt to get IntelliJ IDEA working with
SWF from AWS.


1 - Install aspectJ-weaver plugin on IntelliJ from here: https://plugins.jetbrains.com/plugin/1127-aspectj-weaver
2 - Enable it, go to Build->Aspect Weaving and check it.
3 - Go to File->Settings->Build,Execution,Deployment->Compiler->Annotation Processors
4 - Check Enable annotation processing and then check Module content root
5 - Rebuild everything.
6 - On the demo project, go to src->main make the "generate" folder as source root.
