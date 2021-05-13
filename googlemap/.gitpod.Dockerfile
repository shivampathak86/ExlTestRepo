FROM gitpod/workspace-full-vnc

USER gitpod

RUN sudo apt-get -q update && \
    sudo apt-get install -yq chromium-browser && \
    sudo rm -rf /var/lib/apt/lists/*
    
RUN sudo apt-get update \
&& sudo apt-get install -y \
   unzip \
   wget \
   libnss3 \
&& sudo rm -rf /var/lib/apt/lists/* \
&& sudo echo "progress = dot:giga" | tee /etc/wgetrc \
&& sudo mkdir -p /mnt /opt /data \
&& sudo wget https://github.com/andmarios/duphard/releases/download/v1.0/duphard -O /bin/duphard \
&& sudo chmod +x /bin/duphard
