#region --- Au3Recorder generated code Start (v3.3.9.5 KeyboardLayout=00000409)  ---

#region --- Internal functions Au3Recorder Start ---
Func _Au3RecordSetup()
Opt('WinWaitDelay',100)
Opt('WinDetectHiddenText',1)
Opt('MouseCoordMode',0)
Local $aResult = DllCall('User32.dll', 'int', 'GetKeyboardLayoutNameW', 'wstr', '')
If $aResult[1] <> '00000409' Then
  MsgBox(64, 'Warning', 'Recording has been done under a different Keyboard layout' & @CRLF & '(00000409->' & $aResult[1] & ')')
EndIf

EndFunc

Func _WinWaitActivate($title,$text,$timeout=0)
	WinWait($title,$text,$timeout)
	If Not WinActive($title,$text) Then WinActivate($title,$text)
	WinWaitActive($title,$text,$timeout)
EndFunc

_AU3RecordSetup()
#endregion --- Internal functions Au3Recorder End ---

_WinWaitActivate("Demo Form for practicing Selenium Automation - Mozilla Firefox","")
MouseMove(453,297)
MouseDown("left")
MouseMove(454,297)
MouseUp("left")
_WinWaitActivate("Opening Test-File-to-Download.xlsx","")
MouseClick("left",290,299,1)
_WinWaitActivate("Program Manager","")
MouseClick("left",956,751,1)
MouseClick("left",1002,750,1)
_WinWaitActivate("Opening Test-File-to-Download.xlsx","")
MouseClick("left",73,18,1)
MouseMove(77,205)
MouseDown("left")
MouseMove(77,204)
MouseUp("left")
MouseClick("left",285,296,1)
#endregion --- Au3Recorder generated code End ---
