/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2013-2015 Denis Forveille (titou10.titou10@gmail.com)
 * Copyright (C) 2010-2016 Serge Rieder (serge@jkiss.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (version 2)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package org.jkiss.dbeaver.ext.db2.manager;

import org.jkiss.code.Nullable;
import org.jkiss.dbeaver.ext.db2.model.DB2DataSource;
import org.jkiss.dbeaver.ext.db2.model.DB2Schema;
import org.jkiss.dbeaver.ext.db2.model.fed.DB2Wrapper;
import org.jkiss.dbeaver.model.impl.DBSObjectCache;

/**
 * DB2 Federated Wrapper Manager
 * 
 * @author Denis Forveille
 */
public class DB2WrapperManager extends DB2AbstractDropOnlyManager<DB2Wrapper, DB2Schema> {

    private static final String SQL_DROP = "DROP WRAPPER %s";

    @Override
    public String buildDropStatement(DB2Wrapper db2Wrapper)
    {
        String name = db2Wrapper.getName();
        return String.format(SQL_DROP, name);
    }

    @Nullable
    @Override
    public DBSObjectCache<DB2DataSource, DB2Wrapper> getObjectsCache(DB2Wrapper db2Wrapper)
    {
        return db2Wrapper.getDataSource().getWrapperCache();
    }
}
