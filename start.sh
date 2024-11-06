#!/bin/sh
watchexec -i build -i .idea -i .git -i .gradle -i .kotlin -i .vscode -i src/test -- ./tcr.sh
