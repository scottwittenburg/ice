/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/

#ifndef TESTERPROPERTYTYPE_H
#define TESTERPROPERTYTYPE_H

/**
 * The TesterPropertyType enumeration consists of literals representing each type of configuration property
 * used by UpdaterTester and LibcurlUtilsTester.
 */
enum TesterPropertyType {

    /**
     * This literal indicates the maximum number of posts that are randomly selected by the tester.
     */
    MAX_NUMBER_OF_POSTS = 0,

    /**
     * This literal indicates the maximum amount of time in milliseconds between each random post.
     */
    MAX_POST_TIME_INTERVAL,

    /**
     * This literal indicates the url to the directory containing the required remote host testing files.
     */
    URL_PATH,

    /**
     * This literal indicates whether or not cURL calls will verify that the server's certificate
     * was generated by a Certificate Authority.
     */
    IGNORE_SSL_PEER_VERIFICATION,

    /**
     * The user name for the test
     */
    USER_NAME,

    /**
     * The password for the test
     */
    PASS_WORD

};

#endif
