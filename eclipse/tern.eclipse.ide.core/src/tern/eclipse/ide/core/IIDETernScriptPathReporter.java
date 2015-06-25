/**
 *  Copyright (c) 2013-2015 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package tern.eclipse.ide.core;

import org.eclipse.core.runtime.IPath;

import tern.eclipse.ide.internal.core.scriptpath.IIDETernScriptPath;

/**
 * Tern script path reporter.
 *
 */
public interface IIDETernScriptPathReporter {

	void report(IPath path, IIDETernScriptPath scriptPath, String message, boolean include);

}