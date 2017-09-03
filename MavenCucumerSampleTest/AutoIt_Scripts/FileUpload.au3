#Region ;**** Directives created by AutoIt3Wrapper_GUI ****
#AutoIt3Wrapper_Outfile_x64=C:\WorkSpace\aftTesting\AutoIt_Scripts\FileUpload.exe
#AutoIt3Wrapper_UseX64=y
#EndRegion ;**** Directives created by AutoIt3Wrapper_GUI ****

Local $windowhandle=WinWait("[CLASS:#32770]","",10)
ControlFocus($windowhandle,"","Edit1")
Sleep(2000)
ControlSetText($windowhandle,"","Edit1","C:\WorkSpace\aftTesting\AutoIt_Scripts\EmailIdAlreadyExisits.exe")
Sleep(2000)
ControlShow($windowhandle,"","Edit1")
ControlClick($windowhandle,"","Button1")