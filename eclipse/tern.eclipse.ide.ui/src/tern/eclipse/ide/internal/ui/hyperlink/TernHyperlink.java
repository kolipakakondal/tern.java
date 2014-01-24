/*******************************************************************************
 * Copyright (c) 2013 Angelo ZERR.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:      
 *     Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 *******************************************************************************/
package tern.eclipse.ide.internal.ui.hyperlink;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

import tern.eclipse.ide.core.IDETernProject;
import tern.eclipse.ide.internal.ui.TernUIMessages;
import tern.eclipse.ide.ui.hyperlink.AbstractTernHyperlink;
import tern.eclipse.ide.ui.utils.IDETernProtcolHelper;
import tern.server.protocol.TernDoc;
import tern.server.protocol.definition.TernDefinitionQuery;

/**
 * Tern hyperlink used to "go to the definition" of js element by using tern
 * definition.
 * 
 */
public class TernHyperlink extends AbstractTernHyperlink {

	private final IDocument document;
	private final IResource resource;

	public TernHyperlink(IDocument document, IRegion region,
			IResource resource, IDETernProject ternProject) {
		super(region, ternProject);
		this.document = document;
		this.resource = resource;
	}

	@Override
	public String getTypeLabel() {
		return TernUIMessages.TernHyperlink_typeLabel;
	}

	@Override
	public String getHyperlinkText() {
		return TernUIMessages.TernHyperlink_text;
	}

	public TernDoc createDoc() {
		IFile file = (IFile) resource;
		String filename = ternProject.getFileManager().getFileName(file);
		Integer pos = region.getOffset();
		TernDefinitionQuery query = new TernDefinitionQuery(filename, pos);
		TernDoc doc = new TernDoc(query);
		IDETernProtcolHelper.updateDoc(doc, file, document,
				ternProject.getFileManager());
		return doc;
	}

}