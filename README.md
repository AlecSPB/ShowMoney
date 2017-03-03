# FreeSnackbar

This is a free Snackbar on android.You can set its position by using 'setLayoutGravity';
```
FreeSnackbar freeSnackbar = FreeSnackbar.make(tvTitle,"hahaha",FreeSnackbar.LENGTH_SHORT);
        freeSnackbar.setLayoutGravity(FreeSnackbar.TOP);
        freeSnackbar.show();
```
or use Constructor field just like:

```
FreeSnackbar
    .make(tvTitle, "Hehehe", FreeSnackbar.TOP, FreeSnackbar.LENGTH_SHORT)
    .show();
```

Download
--------
The latest version can be downloaded in [zip][zip] and referenced by your application as a library
project.

You can also depend on the library through Maven:
```xml
<dependency>
  <groupId>com.jekyll.wu.widget</groupId>
  <artifactId>freesnackbar</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```
or Gradle:
```groovy
compile 'com.jekyll.wu.widget:freesnackbar:1.0.1'
```

icense
-------

    Copyright 2012 Square, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

  [zip]: https://github.com/JieJacket/ShowMoney/archive/master.zip