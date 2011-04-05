/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.mime4j.stream;

import org.apache.james.mime4j.util.LangUtils;

public final class NameValuePair {

    private final String name;
    private final String value;
    private final boolean quoted;

    public NameValuePair(final String name, final String value, boolean quoted) {
        super();
        if (name == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.name = name;
        this.value = value;
        this.quoted = quoted;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isQuoted() {
        return this.quoted;
    }

    public String toString() {
        if (this.value == null) {
            return name;
        } else {
            StringBuilder buffer = new StringBuilder();
            buffer.append(this.name);
            buffer.append("=");
            if (this.quoted) {
                buffer.append("\"");
            }
            buffer.append(this.value);
            if (this.quoted) {
                buffer.append("\"");
            }
            return buffer.toString();
        }
    }

    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object instanceof NameValuePair) {
            NameValuePair that = (NameValuePair) object;
            return this.name.equals(that.name)
                  && LangUtils.equals(this.value, that.value);
        } else {
            return false;
        }
    }

    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        return hash;
    }

}
