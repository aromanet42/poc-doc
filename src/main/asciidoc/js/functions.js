/**
 * Copyright (C) 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 */

$(function() {
    $('.example').collapse();

    $('.toggle-example').click(function () {
        $(this).next().collapse('toggle');
    });

    console.log('oooo');
});
