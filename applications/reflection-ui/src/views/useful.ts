import React from "react";

import { element } from "./reactTools";
import { getpage } from "./layout";

const useful: React.FC<{}> = () => element(
    "div",
    { className: "header" },
    "Maybe Useful"
);

const page = getpage(useful);

const dependencyInjection: React.FC<{}> = page("Dependency Injection");
const proxies: React.FC<{}> = page("Proxies");

export {
    useful
    , dependencyInjection
    , proxies
};
