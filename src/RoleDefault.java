在生成代码时，模板发生了如下语法错误：
org.apache.velocity.exception.ParseErrorException: Encountered "<EOF>" at Velocity Code Generate[line 97, column 2]
Was expecting one of:
    "(" ...
    <RPAREN> ...
    <ESCAPE_DIRECTIVE> ...
    <SET_DIRECTIVE> ...
    "##" ...
    "\\\\" ...
    "\\" ...
    <TEXT> ...
    "*#" ...
    "*#" ...
    "]]#" ...
    <STRING_LITERAL> ...
    <END> ...
    <IF_DIRECTIVE> ...
    <INTEGER_LITERAL> ...
    <FLOATING_POINT_LITERAL> ...
    <WORD> ...
    <BRACKETED_WORD> ...
    <IDENTIFIER> ...
    <DOT> ...
    "{" ...
    "}" ...
    <EMPTY_INDEX> ...
    
	at org.apache.velocity.runtime.RuntimeInstance.evaluate(RuntimeInstance.java:1301)
	at org.apache.velocity.runtime.RuntimeInstance.evaluate(RuntimeInstance.java:1265)
	at org.apache.velocity.app.VelocityEngine.evaluate(VelocityEngine.java:199)
	at com.sjhy.plugin.tool.VelocityUtils.generate(VelocityUtils.java:62)
	at com.sjhy.plugin.service.impl.CodeGenerateServiceImpl.generate(CodeGenerateServiceImpl.java:127)
	at com.sjhy.plugin.service.impl.CodeGenerateServiceImpl.generateByUnifiedConfig(CodeGenerateServiceImpl.java:94)
	at com.sjhy.plugin.ui.SelectSavePath.onOK(SelectSavePath.java:217)
	at com.sjhy.plugin.ui.SelectSavePath.lambda$new$0(SelectSavePath.java:140)
	at javax.swing.AbstractButton.fireActionPerformed(AbstractButton.java:2022)
	at javax.swing.AbstractButton$Handler.actionPerformed(AbstractButton.java:2348)
	at javax.swing.DefaultButtonModel.fireActionPerformed(DefaultButtonModel.java:402)
	at javax.swing.DefaultButtonModel.setPressed(DefaultButtonModel.java:259)
	at javax.swing.plaf.basic.BasicButtonListener.mouseReleased(BasicButtonListener.java:252)
	at java.awt.Component.processMouseEvent(Component.java:6548)
	at javax.swing.JComponent.processMouseEvent(JComponent.java:3325)
	at java.awt.Component.processEvent(Component.java:6313)
	at java.awt.Container.processEvent(Container.java:2237)
	at java.awt.Component.dispatchEventImpl(Component.java:4903)
	at java.awt.Container.dispatchEventImpl(Container.java:2295)
	at java.awt.Component.dispatchEvent(Component.java:4725)
	at java.awt.LightweightDispatcher.retargetMouseEvent(Container.java:4889)
	at java.awt.LightweightDispatcher.processMouseEvent(Container.java:4526)
	at java.awt.LightweightDispatcher.dispatchEvent(Container.java:4467)
	at java.awt.Container.dispatchEventImpl(Container.java:2281)
	at java.awt.Window.dispatchEventImpl(Window.java:2746)
	at java.awt.Component.dispatchEvent(Component.java:4725)
	at java.awt.EventQueue.dispatchEventImpl(EventQueue.java:764)
	at java.awt.EventQueue.access$500(EventQueue.java:98)
	at java.awt.EventQueue$3.run(EventQueue.java:715)
	at java.awt.EventQueue$3.run(EventQueue.java:709)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:80)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:90)
	at java.awt.EventQueue$4.run(EventQueue.java:737)
	at java.awt.EventQueue$4.run(EventQueue.java:735)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:80)
	at java.awt.EventQueue.dispatchEvent(EventQueue.java:734)
	at com.intellij.ide.IdeEventQueue.defaultDispatchEvent(IdeEventQueue.java:719)
	at com.intellij.ide.IdeEventQueue._dispatchEvent(IdeEventQueue.java:664)
	at com.intellij.ide.IdeEventQueue.dispatchEvent(IdeEventQueue.java:363)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:201)
	at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:116)
	at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:109)
	at java.awt.WaitDispatchSupport$2.run(WaitDispatchSupport.java:190)
	at java.awt.WaitDispatchSupport$4.run(WaitDispatchSupport.java:235)
	at java.awt.WaitDispatchSupport$4.run(WaitDispatchSupport.java:233)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.awt.WaitDispatchSupport.enter(WaitDispatchSupport.java:233)
	at java.awt.Dialog.show(Dialog.java:1077)
	at java.awt.Component.show(Component.java:1685)
	at java.awt.Component.setVisible(Component.java:1637)
	at java.awt.Window.setVisible(Window.java:1014)
	at java.awt.Dialog.setVisible(Dialog.java:998)
	at com.sjhy.plugin.ui.SelectSavePath.open(SelectSavePath.java:362)
	at com.sjhy.plugin.actions.MainAction.actionPerformed(MainAction.java:46)
	at com.intellij.openapi.actionSystem.ex.ActionUtil$1.run(ActionUtil.java:258)
	at com.intellij.openapi.actionSystem.ex.ActionUtil.performActionDumbAware(ActionUtil.java:275)
	at com.intellij.openapi.actionSystem.impl.ActionMenuItem$ActionTransmitter.lambda$actionPerformed$0(ActionMenuItem.java:287)
	at com.intellij.openapi.wm.impl.FocusManagerImpl.runOnOwnContext(FocusManagerImpl.java:283)
	at com.intellij.openapi.wm.impl.IdeFocusManagerImpl.runOnOwnContext(IdeFocusManagerImpl.java:106)
	at com.intellij.openapi.actionSystem.impl.ActionMenuItem$ActionTransmitter.actionPerformed(ActionMenuItem.java:277)
	at javax.swing.AbstractButton.fireActionPerformed(AbstractButton.java:2022)
	at com.intellij.openapi.actionSystem.impl.ActionMenuItem.lambda$fireActionPerformed$0(ActionMenuItem.java:111)
	at com.intellij.openapi.application.TransactionGuardImpl.runSyncTransaction(TransactionGuardImpl.java:88)
	at com.intellij.openapi.application.TransactionGuardImpl.lambda$submitTransaction$1(TransactionGuardImpl.java:111)
	at com.intellij.openapi.application.TransactionGuardImpl.submitTransaction(TransactionGuardImpl.java:120)
	at com.intellij.openapi.application.TransactionGuard.submitTransaction(TransactionGuard.java:122)
	at com.intellij.openapi.actionSystem.impl.ActionMenuItem.fireActionPerformed(ActionMenuItem.java:111)
	at com.intellij.ui.plaf.beg.BegMenuItemUI.doClick(BegMenuItemUI.java:522)
	at com.intellij.ui.plaf.beg.BegMenuItemUI.access$300(BegMenuItemUI.java:35)
	at com.intellij.ui.plaf.beg.BegMenuItemUI$MyMouseInputHandler.mouseReleased(BegMenuItemUI.java:544)
	at java.awt.Component.processMouseEvent(Component.java:6548)
	at javax.swing.JComponent.processMouseEvent(JComponent.java:3325)
	at java.awt.Component.processEvent(Component.java:6313)
	at java.awt.Container.processEvent(Container.java:2237)
	at java.awt.Component.dispatchEventImpl(Component.java:4903)
	at java.awt.Container.dispatchEventImpl(Container.java:2295)
	at java.awt.Component.dispatchEvent(Component.java:4725)
	at java.awt.LightweightDispatcher.retargetMouseEvent(Container.java:4889)
	at java.awt.LightweightDispatcher.processMouseEvent(Container.java:4526)
	at java.awt.LightweightDispatcher.dispatchEvent(Container.java:4467)
	at java.awt.Container.dispatchEventImpl(Container.java:2281)
	at java.awt.Window.dispatchEventImpl(Window.java:2746)
	at java.awt.Component.dispatchEvent(Component.java:4725)
	at java.awt.EventQueue.dispatchEventImpl(EventQueue.java:764)
	at java.awt.EventQueue.access$500(EventQueue.java:98)
	at java.awt.EventQueue$3.run(EventQueue.java:715)
	at java.awt.EventQueue$3.run(EventQueue.java:709)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:80)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:90)
	at java.awt.EventQueue$4.run(EventQueue.java:737)
	at java.awt.EventQueue$4.run(EventQueue.java:735)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:80)
	at java.awt.EventQueue.dispatchEvent(EventQueue.java:734)
	at com.intellij.ide.IdeEventQueue.defaultDispatchEvent(IdeEventQueue.java:719)
	at com.intellij.ide.IdeEventQueue._dispatchEvent(IdeEventQueue.java:664)
	at com.intellij.ide.IdeEventQueue.dispatchEvent(IdeEventQueue.java:363)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:201)
	at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:116)
	at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:105)
	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:93)
	at java.awt.EventDispatchThread.run(EventDispatchThread.java:82)